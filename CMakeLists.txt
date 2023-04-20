cmake_minimum_required(VERSION 3.25)
project(TriangleSplit)

set(CMAKE_CXX_STANDARD 17)

add_executable(TriangleSplit main.cpp DataStorageSystem.cpp DataStorageSystem.h OpenFile.cpp OpenFile.h)
