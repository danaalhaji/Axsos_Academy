import logo from './logo.svg';
import './App.css';
import Welcome from './components/Welcome';
import { Router } from '@reach/router';
import Hello from './components/Hello';

function App() {
  return (
    <div className="App">
      <Router>
        <Welcome path="/home"></Welcome>
        <Hello path="/:hello"></Hello>
        <Hello path="/:hello/:color"></Hello>
        <Hello path="/:hello/:color/:backcolor"></Hello>
      </Router>
    </div>
  );
}

export default App;
