#include "hello.hh"

#ifdef HAVE_STD
#  include <iostream>
   using namespace std;
#else
#  include <iostream.h>
#endif

//chama a função dizOla do servidor com argumento "Hello!"
static void ola(Hello_ptr h)
{
  CORBA::String_var src = (const char*) "Hello!";

  CORBA::String_var dest = h->dizOla(src);

  cout << "Eu disse, \"" << (char*)src << "\"." << endl
       << "O Hello objeto respondeu, \"" << (char*)dest <<"\"." << endl;
}

int main(int argc, char** argv)
{
  try {
    CORBA::ORB_var orb = CORBA::ORB_init(argc, argv);

    if (argc != 2) {
      cerr << "usando:  hello_clt <object reference>" << endl;
      return 1;
    }

    CORBA::Object_var obj = orb->string_to_object(argv[1]);

    Hello_var helloref = Hello::_narrow(obj);

    if (CORBA::is_nil(helloref)) {
      cerr << "Can't narrow reference to type Hello (or it was nil)." << endl;
      return 1;
    }
	
//Chama a função ola do cliente 10 vezes.
    for (CORBA::ULong count=0; count<10; count++) 
      ola(helloref);

    orb->destroy();
  }
  catch (CORBA::TRANSIENT&) {
    cerr << "Caught system exception TRANSIENT -- unable to contact the "
         << "server." << endl;
  }
  catch (CORBA::SystemException& ex) {
    cerr << "Caught a CORBA::" << ex._name() << endl;
  }
  catch (CORBA::Exception& ex) {
    cerr << "Caught CORBA::Exception: " << ex._name() << endl;
  }
  return 0;
}
