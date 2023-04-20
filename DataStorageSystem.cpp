//
// Created by Stephen Huang on 4/20/23.
//

#include "DataStorageSystem.h"

DataStorageSystem::DataStorageSystem()
{

}

void DataStorageSystem::welcome()
{
    char choice;
    cout << "Welcome FutureTech data storage system.\n";
    cout << "Please choose one of the following:\n"
         << "[l]og in to an existing account\n";
    cout << "[c]reate a new account\n"
         << "[g]uest log in.\n";
    cin >> choice;
    switch(choice)
    {
        case 'l': logIn(); break;
        case 'c': creatAccount(); break;
        case 'g': guest(); break;
        default:
            cout << "Please try again.\n";
            cin >> choice;
    }
}

void DataStorageSystem::creatAccount()
{
    string username, password;
    cout << "Please enter your username.\n";
    cin >> username;
    cout << "Please enter your password.\n";
    cin >> password;
}

void DataStorageSystem::logIn()
{
    string username, password;
    cout << "Please enter your username.\n";
    cin >> username;
    cout << "Please enter your password.\n";
    cin >> password;

    while(!matching(username,password))
    {
        cout << "Your username does not match your password.\n"
             << "Please try again.\n";
        cout << "Please enter your username.\n";
        cin >> username;
        cout << "Please enter your password.\n";
        cin >> password;
    }
    cout << "Welcome back, " << username;

}


void DataStorageSystem::guest()
{
    cout << "Welcome use12580 \n";

}

bool DataStorageSystem::matching(const string& user ,const string& ps)
{
    return op.checkLogIn(user,ps);
}

