import './App.css';
import AppLayout from "./AppLayout";
import HBAuthProvider from "./security/HBAuthProvider";
import {ConfigProvider, theme} from "antd";

function App() {
  return (
    <div className="App">
      <ConfigProvider
        theme={{
          algorithm: theme.compactAlgorithm
        }}
      >
        <HBAuthProvider>
          <AppLayout />
        </HBAuthProvider>
      </ConfigProvider>
    </div>
  );
}

export default App;
