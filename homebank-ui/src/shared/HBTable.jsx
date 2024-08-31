import React, {useEffect, useState} from "react";
import {Table} from "antd";

const HBTable = ({columns, getDataMethod}) => {
  const [data, setData] = useState([]);
  const [loading, setLoading] = useState(true);
  const [error, setError] = useState(null);

  const fetchData = async (page = 0, size = 10) => {
    try {
      setLoading(true);
      const data = await getDataMethod({page, size});
      setData(data.content);
    } catch (err) {
      setError(err);
    } finally {
      setLoading(false);
    }
  };

  useEffect(() => {
    fetchData();
  }, []);

  if (error) return <div>Error: {error.message}</div>;

  return (<Table
      displayName="Transactions"
      loading={loading}
      columns={columns}
      scroll={{x: "max-content"}}
      pagination={{
        total: 100,
        defaultPageSize: 10,
        showSizeChanger: true,
        pageSizeOptions: [10, 20, 30],
      }}
      onChange={async (pagination, filters, sorter, extra) => {
        await fetchData(pagination.current - 1, pagination.pageSize);
      }}
      dataSource={data}
  />)
};

export default HBTable;
