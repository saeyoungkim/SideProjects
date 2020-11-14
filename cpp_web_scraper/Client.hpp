#pragma once

#include <unistd.h>
#include <openssl/ssl.h>
#include <string>
#include "Logger.hpp"

#define CRLF "\r\n"

class Client {
public:
    virtual void get() = 0;
protected:
    int _fd;
    std::string _body;
};

class HttpClient : public Client{
public:
    // fdからもらったもの
    HttpClient(int fd) : Client() {
        _fd = fd;
    }
    HttpClient& addHeader(const std::string& header, const std::string& contents){
        _body += header + ": " + contents + CRLF;
        return *this;
    }
    // send get request
    void get(){
        _body = "GET / HTTP/1.1\r\n" + _body + CRLF;
        
        INFO(CRLF + _body);
        
        INFO("Body size : " + std::to_string(_body.size()));

        LOG("send get query");

        write(_fd, _body.c_str(), _body.size());

        LOG("sended!!");
    }
private:
    int _fd;
    std::string _body;
};

class HttpsClient : public Client {
public:
    HttpsClient(int fd) : Client() {
        _fd = fd;
    }
    ~HttpsClient() {
        ssl = NULL;
        ctx = NULL;
    }

    HttpsClient& addHeader(const std::string& header, const std::string& contents){
        _body += header + ": " + contents + CRLF;
        return *this;
    }

    void get() {
        SSL_load_error_strings();
        SSL_library_init();

        /* SSL connection*/
        ctx = SSL_CTX_new(SSLv23_client_method());
        ssl = SSL_new(ctx);
        SSL_set_fd(ssl, _fd);
        SSL_connect(ssl);

        _body = "GET / HTTP/1.1\r\n" + _body + CRLF;
        
        INFO(CRLF + _body);
        
        INFO("Body size : " + std::to_string(_body.size()));

        LOG("send GET.");

        SSL_write(ssl, _body.c_str(), (int)strlen(_body.c_str()));

        LOG("successfully sended.");

        int response_len = 0;
        char response_buf[1024];
        while ((response_len = SSL_read(ssl, response_buf, 1023)) > 0){ /* SSL_readで読み込んだレスポンスをresponse_bufに格納.(1バイト以上なら続ける.) */
            
            /* response_bufの内容を出力. */
            printf("%s", response_buf); /* printfでresponse_bufを出力. */
            memset(response_buf, 0, sizeof(char) * response_len); /* memsetでresponse_bufをクリア. */
        }

        printf("end");

        SSL_shutdown(ssl); 
        SSL_free(ssl); 
        SSL_CTX_free(ctx);
    }
private:
    SSL* ssl;
    SSL_CTX* ctx;
};