//
// Created by Stephen Huang on 4/20/23.
//

#include "OpenFile.h"

bool OpenFile::checkLogIn(const std::string& user, const std::string& password)
{
    ifstream newfile("acountInfo.txt");
    string line;
    int index;
    if (newfile.is_open()){   //checking whether the file is open
        string tp;
        while(getline(newfile, tp)){ //read data from file object and put it into string.
//            cout << tp; //print printthe data of the string
            line = tp;
            for (int i = 0; i < tp.size(); ++i) {
                if(tp[i] == ' ')
                    index = i;
            }
        }
        newfile.close(); //close the file object.
    }

    if(line.substr(0,index) == user)
        if(line.substr(index+1,line.size()) == password)
            return true;

//    cout << line.substr(0,index) <<" " <<line.substr(index+1,line.size());
    return false;
}

