import React, { useEffect, useState } from 'react'
import axios from 'axios';
// import { useParams } from "react-router-dom";
    
const Detail = (props) => {
    const [products, setProducts] = useState({})
    // const { id } = useParams();
    
    useEffect(() => {
        axios.get('http://localhost:8000/api/products' +props.id)
            .then(res => setProducts(res.data))
            .catch(err => console.error(err));
    }, []);
    
    return (
        <div>
        </div>
    )
}
    
export default Detail;