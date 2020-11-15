#include "WebScraper.hpp"

int main(int argc, const char* argv[]) {
    WebScraper webScraper;
    
    webScraper.doCrawling(argv[1]);
    return 0;
}