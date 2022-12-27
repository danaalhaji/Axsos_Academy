import { Link } from '@reach/router'
import React from 'react'

const Header = () => {
  return (
    <div style={{display:"flex", margin:"0 auto"}}>
      <h1><Link to="/player/list">Manage player List</Link>
         <Link to="/player/game/1">Manage player Status</Link></h1>
    </div>
  )
}

export default Header
