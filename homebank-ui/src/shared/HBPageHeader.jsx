import React from 'react';
import { Layout, Typography } from 'antd';
import CurrentUserCard from "./CurrentUserCard";

const { Header } = Layout;
const { Title } = Typography;

const HBPageHeader = ({title, actions = [], ...props}) => {
  return (
      <Header style={{ display: 'flex', justifyContent: 'space-between', alignItems: 'center', padding: '0 20px' }}>
        <Title level={3} style={{ color: 'white', margin: 0 }}>
          {title}
        </Title>
        <div>
          {actions}
          <CurrentUserCard />
        </div>
      </Header>
  );
};

export default HBPageHeader;
