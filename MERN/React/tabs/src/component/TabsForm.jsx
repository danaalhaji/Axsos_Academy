import React, { useState } from 'react'
import 'bootstrap/dist/css/bootstrap.min.css';
import Button from 'react-bootstrap/Button';
import ButtonGroup from 'react-bootstrap/ButtonGroup';
import { motion } from "framer-motion";
const TabsForm = (props) => {
    const dict =[{label:"Tab 1", content :"This is Tab 1"}, {label:"Tab 2", content :"This is Tab 2"}, 
    {label:"Tab 3", content :"This is Tab 3"}];
    const [tab , setTab] = useState("");
    console.log(tab);
    const changeToNewTab=(e,newTab)=>{
        setTab(newTab)
        props.changeTab(tab);
        console.log()
    }

  return (
    // style =()=> {{
    //     width: "100px",
    //     height: "100px",
    //     backgroundColor: "red",
    //     position: "relative";
    //     animation: name(),
    //     animation-duration: "4s",
    // }}
    //   @function name(div) {
    //     keyframes
    //   } example {
    //     0%   {backgroundColor:"red", left:"0px", top:"0px"}
    //     25%  {backgroundColor:"yellow", left:"200px", top:"0px"}
    //     50%  {backgroundColor:"blue", left:"200px", top:"200px"}
    //     75%  {backgroundColor:"green", left:"0px", top:"200px"}
    //     100% {backgroundColor:"red", left:"0px", top:"0px"}
    //   }
    <div>
    <ButtonGroup aria-label="Basic example">
      {dict.map((item, index) =>
      <Button variant="warning" key={ index } onClick={(e) => changeToNewTab(e, item.content)}>
      {item.label}</Button>  )}
    </ButtonGroup>
    </div>
  )
}

export default TabsForm
