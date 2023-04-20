//
// Created by Stephen Huang on 4/20/23.
//

#ifndef TRIANGLESPLIT_DATASTORAGESYSTEM_H
#define TRIANGLESPLIT_DATASTORAGESYSTEM_H
#include <iostream>
#include "OpenFile.h"
using namespace std;

class DataStorageSystem {
public:
    DataStorageSystem();
    void welcome();
    void creatAccount();
    void logIn();
    void guest();
private:
    OpenFile op;
    bool matching(const string&,const string&);
};


#endif //TRIANGLESPLIT_DATASTORAGESYSTEM_H
