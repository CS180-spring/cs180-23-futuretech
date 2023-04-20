//
// Created by Stephen Huang on 4/20/23.
//

#ifndef TRIANGLESPLIT_OPENFILE_H
#define TRIANGLESPLIT_OPENFILE_H
#include <iostream>
#include <fstream>
#include <map>
using namespace std;
class OpenFile {
public:
    bool checkLogIn(const std::string&,const std::string& password);
private:
    map<string,string> mps;
};


#endif //TRIANGLESPLIT_OPENFILE_H
