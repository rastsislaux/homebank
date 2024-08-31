import {
  BrowserRouter as Router, Navigate, Route, Routes
} from "react-router-dom";
import TransactionsTablePage from "./domain/transactions/TransactionsTablePage";
import AccountsTablePage from "./domain/accounts/AccountsTablePage";

const AppRouter = () =>
  <Routes>
    <Route path="/" element={<Navigate to="/transactions" replace/>}/>
    <Route path="/transactions" element={<TransactionsTablePage/>}/>
    <Route path="/accounts" element={<AccountsTablePage />}/>
  </Routes>;

export default AppRouter;
