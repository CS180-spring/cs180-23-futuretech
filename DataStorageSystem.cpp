#include "DataStorageSystem.h"

void DataStorageSystem::welcome()
{
    char choice;
    cout << "Welcome FutureTech data storage system.\n";
    cout << "Please choose one of the following\n"
         << "[l]og in to an existing account\n";
    cout << "[c]reate a new account\n"
         << "[g]uest log in.\n";
    cin >> choice;
    
}