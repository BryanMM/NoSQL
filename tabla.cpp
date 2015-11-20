#include "tabla.h"

Tabla::Tabla()
{

}
void Tabla::insertReg(string data)
{
    registro tmp;
    /*for (int i =0; i < this->numSpaces; i++){
        Data tmp1;
        cout << "inserte el valor de: "<<endl;
        cout << this->namespaces.rove(i)->get_data() << endl;
        cin  >> tmp1.data;


    }*/
    this->spaces.insert_tail(tmp);



}
registro Tabla::getReg(registro pReg)
{
    for(int i=0; i < this->spaces.length(); i++)
        return this->spaces.rove((i))->get_data();

}
void Tabla::addSpaces(string name)
{
        this->numSpaces +=1;
        this->namespaces.insert_tail(name);

}
