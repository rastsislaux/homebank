import './App.css';
import AppLayout from "./AppLayout";
import HBAuthProvider from "./security/HBAuthProvider";

function App() {
  return (
    <div className="App">
      <HBAuthProvider>
        <AppLayout />
      </HBAuthProvider>
    </div>
  );
}

export default App;
