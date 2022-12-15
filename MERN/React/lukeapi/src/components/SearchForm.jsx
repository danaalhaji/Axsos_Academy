import React, { useState } from 'react'
import { navigate } from '@reach/router'

import 'bootstrap/dist/css/bootstrap.min.css';
import Form from 'react-bootstrap/Form';
import Button from 'react-bootstrap/Button';

const SearchForm = (props) => {
    const [type, setType] =  useState("people");
    const [id, setID] =  useState("");

    //*Handle submition function  */
    const handleSubmmit =(e)=>{
        e.preventDefault();
        props.recieveData(type,id);
        navigate(`/${type}/${id}`)             
    }
  return (
    <div style={{width:"60%", margin:"0 auto"}}>
      <Form style={{display:"flex justify-content-center"}} onSubmit={handleSubmmit}>
        <div>
        <Form.FloatingLabel>Search For:</Form.FloatingLabel>
            <Form.Select onChange={(e) => setType(e.target.value)}>
              <option value="people">people</option>
              <option value="planets">planets</option>
              <option value="starships">starships</option>
            </Form.Select>
        </div>
        <div>
            <Form.Label>ID:</Form.Label>
            <Form.Control type="text" placeholder="Enter id e.g: 1" onChange={ (e) => setID(e.target.value)} />
            <Form.Text muted>
                Enter the id for your selection,.
            </Form.Text>
        </div>
        <Button type="submit">Search</Button>
            </Form>
    </div>
  )
}

export default SearchForm
