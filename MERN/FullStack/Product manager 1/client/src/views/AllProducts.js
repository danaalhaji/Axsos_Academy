import React, { useEffect, useState } from 'react'
import ProductForm from '../components/ProductForm';
import ProductList from '../components/ProductList';
import axios from 'axios'
import { Link } from '@reach/router';

const AllProducts = (props) => {

    const [products, setProducts] = useState(null);
    const [loaded, setLoaded] = useState(false);

    useEffect(()=>{
        axios.get('http://localhost:8000/api/products')
            .then(res=>{
                setProducts(res.data);
                setLoaded(true);
            })
            .catch(err => console.error(err.response.data));
    },[]);

    const removeFromDom = proId => {
        setProducts(products.filter(product => product._id != proId));
    }

    return (
        <div>
            <ProductForm/>
            <hr/>
            {loaded && <ProductList products={products} removeFromDom={removeFromDom} />}
        </div>
    )
}

export default AllProducts;