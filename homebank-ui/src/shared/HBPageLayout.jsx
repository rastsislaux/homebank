import HBPageHeader from "./HBPageHeader";
import React from "react";

const HBPageLayout = ({title, actions, children}) => {
  return <>
    <HBPageHeader
        title={title}
        actions={actions}
    />
    {children}
  </>
};

export default HBPageLayout;
