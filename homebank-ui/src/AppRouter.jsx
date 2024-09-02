import {
  Route, Routes
} from "react-router-dom";
import TransactionsTablePage from "./domain/transactions/TransactionsTablePage";
import AccountsTablePage from "./domain/accounts/AccountsTablePage";
import HBLoginPage from "./security/HBLoginPage";

import RequireAuth from "./security/RequireAuth";

const AppRouter = () =>
  <Routes>
    <Route path="/" element={<HBLoginPage/>}/>
    <Route path="/transactions" element={
      <RequireAuth>
        <TransactionsTablePage/>
      </RequireAuth>
    }/>
    <Route path="/accounts" element={
      <RequireAuth>
        <AccountsTablePage />
      </RequireAuth>
    }/>
  </Routes>;

export default AppRouter;
