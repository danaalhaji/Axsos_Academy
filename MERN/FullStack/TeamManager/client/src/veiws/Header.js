import { Link } from '@reach/router'
import React from 'react'

const Header = () => {
  return (
    <div style={{display:"flex"}}>
      <Link to="/player/list">Manage player List</Link>
      <Link to="/player/status">Manage player Status</Link>
    </div>
  )
}

export default Header
