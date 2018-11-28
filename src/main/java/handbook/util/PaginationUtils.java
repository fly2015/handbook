package handbook.util;

public final class PaginationUtils {
	private static PaginationUtils instance = null;
	
	private PaginationUtils()
	{
	}
	
	public static PaginationUtils getInstance()
	{
		if(instance == null)
		{
			instance = new PaginationUtils();
		}
		
		return instance;
	}
	
	public Integer getNumberOfPages(Integer numberOfItems, Integer numberOfItemsPerPage)
	{
		return (int)Math.ceil((float)numberOfItems/numberOfItemsPerPage);
	}
	
	
	public Integer verifyRequestedPageNumber(Integer requestedPageNumber, Integer numberOfPages)
	{
		if(requestedPageNumber == null || requestedPageNumber == 0)
		{
			return 1;
		}
		
		if (requestedPageNumber > numberOfPages)
		{
			return numberOfPages;
		}
		
		return requestedPageNumber;
	}
	
	public Integer caculateStartPosition(Integer requestedPageNumber, Integer numberOfItemsPerPage)
	{
		return (requestedPageNumber - 1) * numberOfItemsPerPage;
	}
}
