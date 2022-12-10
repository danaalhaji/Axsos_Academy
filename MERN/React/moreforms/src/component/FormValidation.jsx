import React, {useState} from 'react'

import 'bootstrap/dist/css/bootstrap.min.css';
import Stack from 'react-bootstrap/Stack';
import Button from 'react-bootstrap/Button';
import Col from 'react-bootstrap/Col';
import Form from 'react-bootstrap/Form';
import Row from 'react-bootstrap/Row';
import Badge from 'react-bootstrap/Badge';
import InputGroup from 'react-bootstrap/InputGroup';

const FormValidation = () => {
  const [firstName, setFristName] =  useState("");
  const [lastName, setLastName] =  useState("");
  const [email, setEmail] =  useState("");
  const [passowrd, setPassword] =  useState("");
  const [cPassowrd, setcPassword] =  useState("");

  /* errors states*/
  const [FNameError, setFNameError] = useState("");
  const [LNameError, setLNameError] = useState("");
  const [EmailError, setEmailError] = useState("");
  const [passowrdError, setPassowrdError] = useState("");
  const [cPassowrdError, setCPassowrdError] = useState("");

  /* success messages*/
  const [welcome, setWelcome] = useState("");
  // errors array
  var errorsMessages =[];

  // remove element from array 
  const removeError= (e)=>{
  var index = errorsMessages.indexOf(e);
  console.log(index);

  if (index != -1) errorsMessages.pop(index);
  }

/* on change validations*/

//////First Name Validation ///////////
const handleFristNameValidation = (e) => {
  setFristName(e.target.value);
  if(e.target.value.length < 3 && e.target.value.length != 0 ) {
    setFNameError("Fisrt Name must be 3 characters or longer!");
    errorsMessages.push(FNameError);
    console.log(errorsMessages);
  } else {
    setFNameError("");
    removeError(FNameError);
  }
}
///////Last Name Validation ///////////
const handleLastNameValidation = (e) => {
  setLastName(e.target.value);
  if(e.target.value.length < 3 && e.target.value.length != 0 ) {
    setLNameError("Last Name must be 3 characters or longer!");
    errorsMessages.push(LNameError);
    console.log(errorsMessages);
  } else {
    setLNameError("");
    removeError(LNameError);
  }
}
///////Email Validation ///////////
const handleEmailValidation = (e) => {
  setEmail(e.target.value);
  if(e.target.value.length < 3 && e.target.value.length != 0 ) {
    setEmailError("Email must be 3 characters or longer!");
    errorsMessages.push(EmailError);
  } else {
    setEmailError("");
    removeError(EmailError);
  }
}

/////// Password Validation ///////////
const handlePasswordValidation = (e) => {
  setPassword(e.target.value);
  if(e.target.value.length < 8 && e.target.value.length != 0 ) {
    setPassowrdError("Password must be 8 characters or longer!");
    errorsMessages.push(passowrdError);
  } else {
    setPassowrdError("");
    removeError(passowrdError);
  }
}
/////// Confirm Password Validation ///////////
const handleCPasswordValidation =(e) =>{
  setcPassword(e.target.value);
  if(e.target.value != passowrd ){
  setCPassowrdError("Passwords must Match!") 
  errorsMessages.push(cPassowrdError)}
  else{ setCPassowrdError("")
  removeError(cPassowrdError);
  }
}
/* create user */
  const createUser = (e) => {
    e.preventDefault();
    console.log(errorsMessages);
    if(errorsMessages.length == 0 ){
      console.log(errorsMessages);
      const newUser = { firstName,lastName , email, passowrd, cPassowrd }
    setWelcome(`Welome ${firstName}`);
    }
};
/*reset form */
  const clear=()=>{
    console.log("Hi")
    setFristName("");
    setLastName("");
    setEmail("");
    setPassword("");
    setcPassword("");

    //reset error messages//

    setWelcome("");
    setPassowrdError("");
    setEmailError("");
    setFNameError("");
    setLNameError("");
    setCPassowrdError("");
  }
  return (
    <div>
      <Badge pill bg="primary">
      Create user form
      </Badge>
      <div style={{width:"40%", margin:"0 auto", marginTop:"50px"}}>
        {/* Welcome message if success and create user */}
      {
      {welcome}?
        <h1>{welcome}</h1> :
        ''
      }
      {/* form registeration */}

      <Form onSubmit={ createUser } hasValidation>
      <Stack gap={3}>
        {/* Fisrt Name */}
        <Form.Group as={Row} className="mb-3" controlId="validationCustom05">
        <Form.Label column sm={2} >
          First Name
        </Form.Label>
        <Col sm={10}>
          <Form.Control type="text" placeholder="Last Name" onChange={ handleFristNameValidation } value={ firstName }/>
          {
                    FNameError ?
                    <Form.Text className="text-danger">*{ FNameError } </Form.Text> :
                    ''
                }
        </Col>
      </Form.Group>

        {/* Last name form control */}
        <Form.Group as={Row} className="mb-3" controlId="formHorizontalText">
        <Form.Label column sm={2}>
          Last Name
        </Form.Label>
        <Col sm={10}>
          <Form.Control type="text" placeholder="Last Name" onChange={ handleLastNameValidation } value={ lastName }/>
          {
                    LNameError ?
                    <Form.Text className="text-danger">*{ LNameError } </Form.Text> :
                    ''
                }
        </Col>
      </Form.Group>

        {/* Email form */}
        <Form.Group as={Row} className="mb-3" controlId="formHorizontalEmail">
        <Form.Label column sm={2}>
          Email
        </Form.Label>
        <Col sm={10}>
          <Form.Control type="text" placeholder="Email"onChange={ handleEmailValidation } value={ email} />
          {
                    EmailError ?
                    <Form.Text className="text-danger">*{ EmailError } </Form.Text> :
                    ''
                }
        </Col>
      </Form.Group>
      {/* passowrd */}
        <Form.Group as={Row} className="mb-3" controlId="formHorizontalPassword">
        <Form.Label column sm={2}>
          Password
        </Form.Label>
        <Col sm={10}>
          <Form.Control type="password" placeholder="Password" onChange={ handlePasswordValidation } value={ passowrd }/>
          {
                    passowrdError ?
                    <Form.Text className="text-danger">*{ passowrdError } </Form.Text> :
                    ''
                }
        </Col>
      </Form.Group>
      {/* confrim password */}
        <Form.Group as={Row} className="mb-3" controlId="formHorizontalPassword" value={ cPassowrd }>
        <Form.Label column sm={2}>
        Confirm Password: 
        </Form.Label>
        <Col sm={10}>
          <Form.Control type="password" placeholder="Password" 
          onChange={ handleCPasswordValidation } />
                    {
                    cPassowrdError ?
                    <Form.Text className="text-danger">*{ cPassowrdError } </Form.Text> :
                    ''
                }
        </Col>
      </Form.Group>
      {/* button for create user and reset form */}
      <div className="mb-2" >
        <Button aria-controls="example-collapse-text" type="submit" value="Create User" 
        style={{width:"150px", margin:"0 auto"}}>Create User</Button>
        
        <Button variant="outline-danger"  style={{width:"150px", margin:"0 auto"}} onClick={ clear }>Reset</Button>
        </div>
        </Stack>
      </Form>
    </div>
    </div>
  )
}

export default FormValidation
