import logo from './logo.svg';
import './App.css';
import Header from './component/Header';


function App() {
  return (
    <div className="App">
      <Header firstName="Doe" lastName="Jane" age={45} hairColor="Black" >
      </Header>
      <Header firstName="Smith" lastName="Jhon" age={88} hairColor="Brown" >
      </Header>
    </div>
  );
}

export default App;
