#ifndef REGISTROS_H
#define REGISTROS_H
#include "string"
#include "stdio.h"
#include "linked_list.h"
using namespace std;
template <class B>
struct Data{
    B data;

};
template <class B>
struct registro{
   lista<Data<B> > spaces;

};
template <class B>
class registros
{
public:
    registros();
private:
    lista<Data<B> > spaces;


};

#endif // REGISTROS_H
