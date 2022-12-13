import React from 'react'

const Hello = (props) => {
  return (
    <div>
      {
        isNaN(props.hello)?<p style={{color: props.color, backgroundColor:props.backcolor}}>The word is: {props.hello}</p>:<p> you entered : {props.hello}</p>
      }
    </div>
  )
}

export default Hello
