import React  from 'react'
// import ReactTransitionGroup from 'react-addons-transition-group' // ES6
// var ReactTransitionGroup = require('react-addons-transition-group') 
import 'bootstrap/dist/css/bootstrap.min.css';
import { motion } from "framer-motion";
const TabsDisplay = (props) => {
   return (
    <div>
        <motion.p
            animate={{ x: [50, 150, 50], opacity: 1, scale: 1 }}
            transition={{
                duration: 10,
                delay: 0.6,
                ease: [0.8, 1, 1.5, 1.5],
            }}
            initial={{ opacity: 0, scale: 0.6 }}
            whileHover={{ scale: 1.2 }}
            whileTap={{ scale: 3 }}
            >
        <p style={{color:"red"}}>{props.newChange}</p>
        </motion.p>
    </div>
  )
}

export default TabsDisplay
