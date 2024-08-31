import React from "react";
import {Button} from "antd";
import useTransactionService from "../../api/useTransactionService";
import HBPageHeader from "../../shared/HBPageHeader";
import HBTable from "../../shared/HBTable";
import HBPageLayout from "../../shared/HBPageLayout";

const columns = [{
  title: 'Provider',
  dataIndex: '_provider',
  key: '_provider'
}, {
  title: 'Operation',
  dataIndex: 'operation',
  key: 'operation'
}, {
  title: 'Sum',
  dataIndex: 'sum',
  key: 'sum'
}, {
  title: 'Currency',
  dataIndex: 'currency',
  key: 'currency'
}, {
  title: 'Date',
  dataIndex: 'date',
  key: 'date'
}, {
  title: 'Category',
  dataIndex: 'category',
  key: 'category',
  render: (text) => text ? text : '—'
}];

const TransactionsTablePage = () => {
  const { getTransactions } = useTransactionService();

  return <HBPageLayout
    title="Transactions"
  >
    <HBTable
        columns={columns}
        getDataMethod={getTransactions}
    />
  </HBPageLayout>
};

export default TransactionsTablePage;
