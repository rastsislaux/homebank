import React from 'react';
import {Layout, Menu, Table} from 'antd';
import {DollarOutlined, WalletOutlined} from "@ant-design/icons";
import TransactionsTablePage from "./domain/transactions/TransactionsTablePage";
import AppRouter from "./AppRouter";
import HBSideMenu from "./shared/HBSideMenu";
import {
  BrowserRouter as Router, Navigate, Route, Routes
} from "react-router-dom";

const { Header, Content, Sider } = Layout;

const AppLayout = () => {
  return (
      <Layout style={{ minHeight: '100vh' }}>
        <Router>
          <HBSideMenu />
          <Layout>
            <Content style={{ margin: '0 16px' }}>
              <AppRouter/>
            </Content>
          </Layout>
        </Router>
      </Layout>
  );
};

export default AppLayout;
