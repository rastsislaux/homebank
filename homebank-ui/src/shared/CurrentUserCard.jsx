import React from 'react';
import {Avatar, Button} from 'antd';
import useAuth from "../security/HBAuth";
import {LogoutOutlined} from "@ant-design/icons";

const CurrentUserCard = () => {
  const { getUserinfo, logout } = useAuth();
  const { name, picture } = getUserinfo();

  return (
      <Button
          onClick={logout}
          style={{
            display: 'flex',
            alignItems: 'center',
            padding: '8px 16px',
            border: 'none',
            // background: 'transparent',
            cursor: 'pointer',
          }}
          type="default"
      >
        <Avatar src={picture} size="small" style={{ marginRight: '8px' }} />
        <span>{name || 'User'}</span>
        <LogoutOutlined />
      </Button>
  );
};

export default CurrentUserCard;
