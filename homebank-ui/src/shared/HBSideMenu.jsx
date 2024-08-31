import React from "react";
import {Layout, Menu} from 'antd';
import {DollarOutlined, WalletOutlined} from "@ant-design/icons";
import {useNavigate} from "react-router-dom";

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
  const navigate = useNavigate();

  return <Sider width={200} className="site-layout-background">
    <Menu
        mode="inline"
        defaultSelectedKeys={['1']}
        style={{height: '100%', borderRight: 0, 'padding-top': 15}}
        onClick={e => {
          navigate(e.key);
        }}
    >
      <img style={{backgroundColor: "transparent", padding: 16}} src="logo.png" width="100%"
           height="58px" alt="Homebank Logo"/>
      <hr/>
      {sideMenuData.map(entry => <Menu.Item key={entry.link}
                                            icon={entry.icon}>{entry.title}</Menu.Item>)}
    </Menu>
  </Sider>
};

export default HBSideMenu;
