#ifndef DATA_H
#define DATA_H
#include "string"
#include "iostream"
#include "stdio.h"
using namespace std;

template<class B>

class Data
{
public:
    Data(string type);
    B data;
    string name;
    string dataType;
    B getData();
    void setData(B pData);
};

#endif // DATA_H
