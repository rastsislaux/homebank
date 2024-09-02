import React from 'react';
import { Layout, Typography } from 'antd';
import CurrentUserCard from "./CurrentUserCard";
import useColors from "./useColors";

const { Header } = Layout;
const { Title } = Typography;

const HBPageHeader = ({title, actions = [], ...props}) => {
  const { licorice } = useColors();

  return (
      <Header style={{ display: 'flex', justifyContent: 'space-between', alignItems: 'center', padding: '0 20px', background: licorice }}>
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
