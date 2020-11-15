#include "WebScraper.hpp"
#include "Logger.hpp"
#include "Client.hpp"
#include <arpa/inet.h>
#include <iostream>
#include <sys/socket.h>
#include <unistd.h>

#define HTTP "http"
#define HTTPS "https"

#define MAX_SIZE 4096

WebScraper::WebScraper(const char* url) : _url(url){
    LOG("Instance is created.");
    INFO("URL : " + std::string(_url));
}

WebScraper::WebScraper() {
    LOG("Instance is created.");
}

WebScraper::~WebScraper() {
    LOG("Instance is destroyed.");
}

void WebScraper::doCrawling(const char* url) {
    struct addrinfo* _res = NULL;
    int sock_fd;
    
    LOG("start crwaling.");

    // set url
    _url = url;
    INFO("URL : " + std::string(_url));
    
    // dns look up 結果として一番前のaddrinfoに対する
    // ポインターを取得
    _dns_lookup_result = getAddrInfos(HTTPS);

    LOG("start connect to socket.");

    for(_res = _dns_lookup_result; _res != NULL; _res = _res->ai_next) {
        // get fd from dns lookup address information
        sock_fd = connectSocket(_dns_lookup_result);
    }

    LOG("connected!");
    LOG("create request object");

    HttpsClient client(sock_fd);

    client
        .addHeader("Host",std::string(_url))
        .addHeader("Accept","*/*")
        .get();
        
    LOG("crwaling end");

    freeaddrinfo(_dns_lookup_result);
    LOG("free address information structure.");
    close(sock_fd);
    LOG("socket closed.");
}

struct addrinfo* WebScraper::getAddrInfos(const std::string& service) {
    // hint for dns server query
    struct addrinfo hints = {0};
    // domain - network layer
    hints.ai_family = AF_UNSPEC;
    // socket type - transport layer
    hints.ai_socktype = SOCK_STREAM;
    // socket protocol - application layer
    // hints.ai_protocol = 0;
    // bit mask -
    // hints.ai_flags = AI_ADDRCONFIG;

    // the result which has type of addrinfo
    struct addrinfo* res0 = NULL;
    
    // return 0 -> success
    if(getaddrinfo(_url, service.c_str(), &hints, &res0) != 0) {
        ERROR("cannot get addrinfo from url.");
        freeaddrinfo(res0);
        LOG("free address information structure.");
        std::exit(1);
    }

    printf ("getaddrnfo(%s) :\n%s\n", _url, inet_ntoa(((struct sockaddr_in *)(res0->ai_addr))->sin_addr));

    return res0;
}

int WebScraper::connectSocket(struct addrinfo* res) {
    // make socket
    int sock_fd= socket(res->ai_family, res->ai_socktype, res->ai_protocol);

    // connect
    if(connect(sock_fd, (const struct sockaddr*)(res->ai_addr), sizeof(sockaddr)) != 0){
        ERROR("cannot make socket for listening");
        freeaddrinfo(res);
        LOG("free address information structure.");
        close(sock_fd);
        LOG("socket closed.");
        std::exit(1);
    }

    return sock_fd;
}