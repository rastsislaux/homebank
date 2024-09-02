import React, { useState } from "react";
import { Layout, Menu, Button } from 'antd';
import { DollarOutlined, WalletOutlined, MenuFoldOutlined, MenuUnfoldOutlined } from "@ant-design/icons";
import { useNavigate } from "react-router-dom";
import useAuth from "../security/HBAuth";
import useColors from "./useColors";

const { Sider } = Layout;

const sideMenuData = [
  {
    title: 'Accounts',
    icon: <WalletOutlined />,
    link: '/accounts',
  },
  {
    title: 'Transactions',
    icon: <DollarOutlined />,
    link: '/transactions',
  }
];

const HBSideMenu = () => {
  const { isAuthenticated } = useAuth();
  const navigate = useNavigate();
  const [collapsed, setCollapsed] = useState(false);

  const { licorice } = useColors();

  if (!isAuthenticated()) {
    return null;
  }

  return (
      <Sider collapsible collapsed={collapsed} onCollapse={setCollapsed}
             style={{ background: licorice  }}
             className="site-layout-background">
        <Button
            type="text"
            onClick={() => setCollapsed(!collapsed)}
            style={{ marginBottom: 16, color: 'white' }}
        >
          {collapsed ? <MenuUnfoldOutlined /> : <MenuFoldOutlined />}
        </Button>
        <Menu
            mode="inline"
            defaultSelectedKeys={['1']}
            style={{ height: '100%', borderRight: 0, paddingTop: 15 }}
            onClick={e => {
              navigate(e.key);
            }}
        >
          <img style={{ backgroundColor: "transparent", padding: 16 }} src="logo.png" width="100%" height="58px" alt="Homebank Logo" />
          <hr />
          {sideMenuData.map(entry => (
              <Menu.Item key={entry.link} icon={entry.icon}>
                {entry.title}
              </Menu.Item>
          ))}
        </Menu>
      </Sider>
  );
};

export default HBSideMenu;
