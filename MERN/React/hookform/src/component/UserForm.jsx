import React, {useState} from 'react'
import 'bootstrap/dist/css/bootstrap.min.css';
import Stack from 'react-bootstrap/Stack';
import Button from 'react-bootstrap/Button';
import Col from 'react-bootstrap/Col';
import Form from 'react-bootstrap/Form';
import Row from 'react-bootstrap/Row';
import Badge from 'react-bootstrap/Badge';

const UserForm = (props) => {
  const [firstName, setFristName] =  useState("");
  const [lastName, setLastName] =  useState("");
  const [email, setEmail] =  useState("");
  const [passowrd, setPassword] =  useState("");
  const [cPassowrd, setcPassword] =  useState("");
  const createUser = (e) => {
    e.preventDefault();
    const newUser = { firstName,lastName , email, passowrd, cPassowrd };
    console.log("Welcome", newUser);
};
const clear=()=>{
  setFristName("");
  setLastName("");
  setEmail("");
  setPassword("");
  setcPassword("");
}




  return (

    <div>
        <Badge pill bg="primary">
        Create user form
      </Badge>{' '}
      <div style={{width:"40%", margin:"0 auto", marginTop:"50px"}}>
      <Form onSubmit={ createUser } >
      <Stack gap={3}>
        {/* Fisrt Name */}
        <Form.Group as={Row} className="mb-3" controlId="formHorizontalText">
        <Form.Label column sm={2}>
          First Name
        </Form.Label>
        <Col sm={10}>
          <Form.Control type="text" placeholder="Last Name" onChange={ (e) => setFristName(e.target.value) } value={ firstName }/>
        </Col>
      </Form.Group>

        {/* Last name form control */}
        <Form.Group as={Row} className="mb-3" controlId="formHorizontalText">
        <Form.Label column sm={2}>
          Last Name
        </Form.Label>
        <Col sm={10}>
          <Form.Control type="text" placeholder="Last Name" onChange={ (e) => setLastName(e.target.value) } value={ lastName } />
        </Col>
      </Form.Group>

        {/* Email form */}
        <Form.Group as={Row} className="mb-3" controlId="formHorizontalEmail">
        <Form.Label column sm={2}>
          Email
        </Form.Label>
        <Col sm={10}>
          <Form.Control type="text" placeholder="Email"onChange={ (e) => setEmail(e.target.value) } value={ email } />
        </Col>
      </Form.Group>
      {/* passowrd */}
        <Form.Group as={Row} className="mb-3" controlId="formHorizontalPassword">
        <Form.Label column sm={2}>
          Password
        </Form.Label>
        <Col sm={10}>
          <Form.Control type="password" placeholder="Password" onChange={ (e) => setPassword(e.target.value) }value={ passowrd }/>
        </Col>
      </Form.Group>
      {/* confrim password */}
        <Form.Group as={Row} className="mb-3" controlId="formHorizontalPassword">
        <Form.Label column sm={2}>
        Confirm Password: 
        </Form.Label>
        <Col sm={10}>
          <Form.Control type="password" placeholder="Password" 
          onChange={ (e) => setcPassword(e.target.value) } value={ cPassowrd }/>
        </Col>
      </Form.Group>
      <div className="mb-2" >
        <Button aria-controls="example-collapse-text" type="submit" value="Create User" 
        style={{width:"150px", margin:"0 auto"}}>Create User</Button>
        <Button variant="outline-danger"  style={{width:"150px", margin:"0 auto"}} onClick={ clear }>Reset</Button>
        </div>
        </Stack>
      </Form>

      <div>
      <Badge pill bg="danger">
        From data
      </Badge>{' '}
      <p><span style={{fontWeight: "bold"}}>First Name  </span> {firstName }</p>
      <p><span style={{fontWeight: "bold"}}>Last Name   </span> {lastName }</p>
      <p><span style={{fontWeight: "bold"}} >Email    </span> {email }</p>
      <p><span style={{fontWeight: "bold"}}>Password   </span> {passowrd }</p>
      <p><span style={{fontWeight: "bold"}}>Confirm Password  </span> {cPassowrd  }</p>
      </div>
      </div>
    </div>
  )
}
export default UserForm
