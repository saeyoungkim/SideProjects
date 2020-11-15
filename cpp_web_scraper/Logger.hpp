#pragma once

#include <iostream>

enum class LEVEL {
    INFO, LOG, WARN, ERROR
};

std::string getLevel(const LEVEL& level) {
    if(level == LEVEL::LOG) return "LOG";
    else if(level == LEVEL::INFO) return "INFO";
    else if(level == LEVEL::WARN) return "WARN";
    else if(level == LEVEL::ERROR) return "ERROR";
    return "UNKNOWN";
}

class Logger {
private:
    static std::string generateMessage(const LEVEL& level, const std::string& message) {
        return "[ " + std::string(__TIME__) + " " + getLevel(level) + " ] " + message + "\n";
    }
public:
    static void write(const LEVEL& level, const std::string& message){
        std::cout << generateMessage(level, message);
    }

#define INFO(message) Logger::write(LEVEL::INFO, (message))
#define LOG(message) Logger::write(LEVEL::LOG, (message))
#define WARN(message) Logger::write(LEVEL::WARN, (message))
#define ERROR(message) Logger::write(LEVEL::ERROR, (message))
};