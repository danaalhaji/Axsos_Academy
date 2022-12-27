import React from 'react'
import axios from 'axios';
    
export default props => {
    
    const { playerID, successCallback, name } = props;
    const confirmD =(id)=>{
        let text = `Press a button!\nEither OK if you to delete ${name} or Cancel.`;
        if (window.confirm(text) == true) {
            deletePerson(id)}
        }
    const deletePerson = e => {
        axios.delete('http://localhost:8000/api/player/' + playerID)
            .then(res=>{
                successCallback();
            })
    }
    
    return (
        <button onClick={confirmD}>
            Delete
        </button>
    )
}

