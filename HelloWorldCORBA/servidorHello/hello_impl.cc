#include "hello.hh"

#ifdef HAVE_STD
#  include <iostream>
using namespace std;
#else
#  include <iostream.h>
#endif

//Para o servidor de Nomes
//static CORBA::Boolean bindObjectToName(CORBA::ORB_ptr, CORBA::Object_ptr);

//Classe de implemenção do servant 
class Hello_i : public POA_Hello
{
public:
	inline Hello_i() {}
	virtual ~Hello_i() {}
	virtual char* dizOla(const char* mesg);
};
//recebe uma string, e a retorna
char* Hello_i::dizOla(const char* mesg)
{
	cout << "Para referencia externa: " << mesg << endl;
	return CORBA::string_dup(mesg);
}

int main(int argc, char** argv)
{
	try {
		CORBA::ORB_var          orb = CORBA::ORB_init(argc, argv);
		CORBA::Object_var       obj = orb->resolve_initial_references("RootPOA");
		PortableServer::POA_var poa = PortableServer::POA::_narrow(obj);

		PortableServer::Servant_var<Hello_i> myHello = new Hello_i();

		PortableServer::ObjectId_var myHelloid = poa->activate_object(myHello);

		// Obtendo uma referencia para o objeto , e escrevendo uma IOR Strinficada
		obj = myHello->_this();
		CORBA::String_var sior(orb->object_to_string(obj));
		cout << sior << endl;

		PortableServer::POAManager_var pman = poa->the_POAManager();
		pman->activate();

		// Bloquia até que a ORB é desligada
		orb->run();
	}
	catch (CORBA::SystemException& ex) {
		cerr << "Caught CORBA::" << ex._name() << endl;
	}
	catch (CORBA::Exception& ex) {
		cerr << "Caught CORBA::Exception: " << ex._name() << endl;
	}
	return 0;
}



