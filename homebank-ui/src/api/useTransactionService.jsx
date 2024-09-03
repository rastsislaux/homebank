import useAuthenticatedApi from "./useAuthenticatedApi";

const useTransactionService = () => {
  const { get } = useAuthenticatedApi("/api/v1/transactions");

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
