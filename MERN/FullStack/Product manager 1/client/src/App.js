import logo from './logo.svg';
import './App.css';
import AllProducts from './views/AllProducts';
import { Router } from '@reach/router'
function App() {
  return (
    <div className="App">
      <Router>
        <AllProducts path="/"></AllProducts>
      </Router>
    </div>
  );
}

export default App;
