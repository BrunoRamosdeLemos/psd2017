// This file is generated by omniidl (C++ backend)- omniORB_4_2. Do not edit.

#include "hello.hh"
#include <omniORB4/IOP_S.h>
#include <omniORB4/IOP_C.h>
#include <omniORB4/callDescriptor.h>
#include <omniORB4/callHandle.h>
#include <omniORB4/objTracker.h>


OMNI_USING_NAMESPACE(omni)

static const char* _0RL_library_version = omniORB_4_2;



Hello_ptr Hello_Helper::_nil() {
	return ::Hello::_nil();
}

::CORBA::Boolean Hello_Helper::is_nil(::Hello_ptr p) {
	return ::CORBA::is_nil(p);

}

void Hello_Helper::release(::Hello_ptr p) {
	::CORBA::release(p);
}

void Hello_Helper::marshalObjRef(::Hello_ptr obj, cdrStream& s) {
	::Hello::_marshalObjRef(obj, s);
}

Hello_ptr Hello_Helper::unmarshalObjRef(cdrStream& s) {
	return ::Hello::_unmarshalObjRef(s);
}

void Hello_Helper::duplicate(::Hello_ptr obj) {
	if (obj && !obj->_NP_is_nil())  omni::duplicateObjRef(obj);
}

Hello_ptr
Hello::_duplicate(::Hello_ptr obj)
{
	if (obj && !obj->_NP_is_nil())  omni::duplicateObjRef(obj);
	return obj;
}

Hello_ptr
Hello::_narrow(::CORBA::Object_ptr obj)
{
	if (!obj || obj->_NP_is_nil() || obj->_NP_is_pseudo()) return _nil();
	_ptr_type e = (_ptr_type)obj->_PR_getobj()->_realNarrow(_PD_repoId);
	return e ? e : _nil();
}


Hello_ptr
Hello::_unchecked_narrow(::CORBA::Object_ptr obj)
{
	if (!obj || obj->_NP_is_nil() || obj->_NP_is_pseudo()) return _nil();
	_ptr_type e = (_ptr_type)obj->_PR_getobj()->_uncheckedNarrow(_PD_repoId);
	return e ? e : _nil();
}

Hello_ptr
Hello::_nil()
{
#ifdef OMNI_UNLOADABLE_STUBS
	static _objref_Hello _the_nil_obj;
	return &_the_nil_obj;
#else
	static _objref_Hello* _the_nil_ptr = 0;
	if (!_the_nil_ptr) {
		omni::nilRefLock().lock();
		if (!_the_nil_ptr) {
			_the_nil_ptr = new _objref_Hello;
			registerNilCorbaObject(_the_nil_ptr);
		}
		omni::nilRefLock().unlock();
	}
	return _the_nil_ptr;
#endif
}

const char* Hello::_PD_repoId = "IDL:Hello:1.0";


_objref_Hello::~_objref_Hello() {

}


_objref_Hello::_objref_Hello(omniIOR* ior, omniIdentity* id) :
	omniObjRef(::Hello::_PD_repoId, ior, id, 1)


{
	_PR_setobj(this);
}

void*
_objref_Hello::_ptrToObjRef(const char* id)
{
	if (id == ::Hello::_PD_repoId)
		return (::Hello_ptr) this;

	if (id == ::CORBA::Object::_PD_repoId)
		return (::CORBA::Object_ptr) this;

	if (omni::strMatch(id, ::Hello::_PD_repoId))
		return (::Hello_ptr) this;

	if (omni::strMatch(id, ::CORBA::Object::_PD_repoId))
		return (::CORBA::Object_ptr) this;

	return 0;
}


//
// Code for Hello::dizOla

// Proxy call descriptor class. Mangled signature:
//  _cstring_i_cstring
class _0RL_cd_627bfbf675d4fdb9_00000000
	: public omniCallDescriptor
{
public:
	inline _0RL_cd_627bfbf675d4fdb9_00000000(LocalCallFn lcfn, const char* op_, size_t oplen, _CORBA_Boolean upcall = 0)
		: omniCallDescriptor(lcfn, op_, oplen, 0, _user_exns, 0, upcall)
	{

	}

	void marshalArguments(cdrStream&);
	void unmarshalArguments(cdrStream&);

	void unmarshalReturnedValues(cdrStream&);
	void marshalReturnedValues(cdrStream&);


	static const char* const _user_exns[];

	::CORBA::String_var arg_0_;
	const char* arg_0;
	::CORBA::String_var result;
};

void _0RL_cd_627bfbf675d4fdb9_00000000::marshalArguments(cdrStream& _n)
{
	_n.marshalString(arg_0, 0);

}

void _0RL_cd_627bfbf675d4fdb9_00000000::unmarshalArguments(cdrStream& _n)
{
	arg_0_ = _n.unmarshalString(0);
	arg_0 = arg_0_.in();

}

void _0RL_cd_627bfbf675d4fdb9_00000000::marshalReturnedValues(cdrStream& _n)
{
	_n.marshalString(result, 0);

}

void _0RL_cd_627bfbf675d4fdb9_00000000::unmarshalReturnedValues(cdrStream& _n)
{
	result = _n.unmarshalString(0);

}

const char* const _0RL_cd_627bfbf675d4fdb9_00000000::_user_exns[] = {
	0
};

// Local call call-back function.
static void
_0RL_lcfn_627bfbf675d4fdb9_10000000(omniCallDescriptor* cd, omniServant* svnt)
{
	_0RL_cd_627bfbf675d4fdb9_00000000* tcd = (_0RL_cd_627bfbf675d4fdb9_00000000*)cd;
	_impl_Hello* impl = (_impl_Hello*)svnt->_ptrToInterface(Hello::_PD_repoId);
	tcd->result = impl->dizOla(tcd->arg_0);


}

char* _objref_Hello::dizOla(const char* mesg)
{
	_0RL_cd_627bfbf675d4fdb9_00000000 _call_desc(_0RL_lcfn_627bfbf675d4fdb9_10000000, "dizOla", 7);
	_call_desc.arg_0 = mesg;

	_invoke(_call_desc);
	return _call_desc.result._retn();


}

_pof_Hello::~_pof_Hello() {}


omniObjRef*
_pof_Hello::newObjRef(omniIOR* ior, omniIdentity* id)
{
	return new ::_objref_Hello(ior, id);
}


::CORBA::Boolean
_pof_Hello::is_a(const char* id) const
{
	if (omni::ptrStrMatch(id, ::Hello::_PD_repoId))
		return 1;

	return 0;
}

const _pof_Hello _the_pof_Hello;

_impl_Hello::~_impl_Hello() {}


::CORBA::Boolean
_impl_Hello::_dispatch(omniCallHandle& _handle)
{
	const char* op = _handle.operation_name();

	if (omni::strMatch(op, "dizOla")) {

		_0RL_cd_627bfbf675d4fdb9_00000000 _call_desc(_0RL_lcfn_627bfbf675d4fdb9_10000000, "dizOla", 7, 1);

		_handle.upcall(this, _call_desc);
		return 1;
	}


	return 0;
}

void*
_impl_Hello::_ptrToInterface(const char* id)
{
	if (id == ::Hello::_PD_repoId)
		return (::_impl_Hello*) this;

	if (id == ::CORBA::Object::_PD_repoId)
		return (void*)1;

	if (omni::strMatch(id, ::Hello::_PD_repoId))
		return (::_impl_Hello*) this;

	if (omni::strMatch(id, ::CORBA::Object::_PD_repoId))
		return (void*)1;
	return 0;
}

const char*
_impl_Hello::_mostDerivedRepoId()
{
	return ::Hello::_PD_repoId;
}

POA_Hello::~POA_Hello() {}


