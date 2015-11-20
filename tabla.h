#ifndef REGISTRO_H
#define REGISTRO_H
#include <string>
#include "stdio.h"
#include "linked_list.h"
using namespace std;
struct Data{
  string data;
};

struct registro{

    lista<Data> Dataspaces;
};

class Tabla
{
public:

    Tabla();
    int numSpaces=0;
    lista<string> namespaces;
    lista<registro> spaces;
    void insertReg (string data);
    registro getReg(registro pReg);
    void addSpaces(string name);




};

#endif // REGISTRO_H
