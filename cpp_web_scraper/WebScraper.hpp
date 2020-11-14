#pragma once

#include <sys/types.h> // what
#include <sys/socket.h> // getaddrinfo
#include <netdb.h> // addrinfo
#include <string>

/*
    client send request from site address
    cli : ./WebScraper <url>
*/
class WebScraper {
public:
    // constructor
    WebScraper(const char*);
    // constructor
    WebScraper();
    // desturctor
    ~WebScraper();
    // ipaddress
    void doCrawling(const char*);
private:
    // url
    const char* _url;
    // 接続先の情報
    addrinfo* _dns_lookup_result;
    // get ip address from dns server
    struct addrinfo* getAddrInfos(const std::string&);
    // 連絡して繋がった際のFDをリターンする
    int connectSocket(struct addrinfo*);
};