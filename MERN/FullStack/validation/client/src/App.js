import logo from './logo.svg';
import './App.css';
import { Router } from '@reach/router'
import Main from './views/Main';
import AuthorDisplay from './components/AuthorDisplay';
import Update from './views/Update';
function App() {
  return (
    <div className="App">
      <Router>
        <Main path="/new"></Main>
        <AuthorDisplay path ="/"></AuthorDisplay>
        <Update path="/update/:id"></Update>
      </Router>
    </div>
  );
}

export default App;
