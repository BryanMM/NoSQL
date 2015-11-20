#include "data.h"
template<class B>
Data::Data(string type)
{
    this->dataType = type;
}
template<class B>
T Data::getData()
{
    return this->data;

}
template<class B>
void Data::setData(B pData)
{
    this->data = pData;
}
