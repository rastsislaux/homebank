import useApi from "./useApi";

const useTransactionService = () => {
  const { get } = useApi("/api/v1/transactions");

  const getTransactions = ({
    page = 0,
    size = 10,
    sortBy = 'date',
    sortOrder = 'DESC'
  }) => get(
      `?page=${page}&size=${size}&sortBy=${sortBy}&sortOrder=${sortOrder}`);

  return {
    getTransactions,
  };
};

export default useTransactionService;
