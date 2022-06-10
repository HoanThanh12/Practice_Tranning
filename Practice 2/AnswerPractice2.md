# Answer Practice 2

## Question 1: btn_accent, btn_normal, btn_etc được sử dụng trong trường hợp nào?

![Question1](../Practice%202/image_question/Question_1.png)

- Dùng để phân biệt các chức năng của nút.

## Question 2: Colgroup có tác dụng gì? Có bắt buộc phải xài hay không?

![Question2](../Practice%202/image_question/Question_2.png)

- Sử dụng trong việc định dạng chung cho toàn bộ cột, thay vì đình dạng riêng, lặp lại cho mỗi hàng.
- Chúng ta không bắt buộc phải sử dụng nó.

## Question 3: Hàm ComsheetObject() để làm gì?

![Question3](../Practice%202/image_question/Question_3.png)

- Tạo đối tượng sheet.

## Question 4: Hàm GetSearchData() để làm gì? Hàm FormQueryString() để làm gì? Hàm LoadSearchData() để làm gì? GetSearchData() và DoSearch() giống và khác nhau? GetSearchData() và DoSearch() dùng trong trường hợp nào?

![Question4](../Practice%202/image_question/Question_4.png)

### Hàm GetSearchData() dùng để làm gì?

- Hàm GetSearchData() dùng để gọi trang tìm kiếm, trả về kiểu dữ liệu tìm kiếm.

### Hàm FormQueryString() dùng để làm gì?

- Hàm FormQueryString() dùng để lấy dữ liệu từ các input.

### Hàm LoadSearchData() dùng để làm gì?

- Hàm LoadSearchData() dùng để Nhận dữ liệu tìm kiếm (xml hoặc json) dưới dạng tham số phương thức và tải vào IBSheet.

### GetSearchData() và DoSearch() giống và khác nhau như thế nào?

- Giống nhau : Đều gọi trang tìm kiếm và trả về kiểu dữ liệu tìm kiếm.

- Khác nhau:
  - DoSearch() : Nó sẽ xử lý kết quả trả về và load lên Sheet. Load dữ liệu lên được là nhờ hàm LoadSearchData() có sẵn trong DoSearch().
  - GetSearchData() : Nó chỉ trả về dữ liệu. Không load dữ liệu lên Sheet. Nếu muốn load dữ liệu lên Sheet phải dùng hàm LoadSearchData().

### GetSearchData() và DoSearch() dùng trong trường hợp nào?

- GetSearchData() sử dụng trong trường hợp ta muốn lấy dữ liệu đã search nhưng không muốn load lên Sheet hoặc ta muốn dùng kết quả đó làm một việc gì đó trước khi đưa lên Sheet.
- DoSearch() sử dụng trong trường hợp ta muốn tìm và load sử liệu đã tìm lên Sheet.

## Question 5: Hàm with() dùng để làm gì? Hàm DataInsert() dùng để làm gì? Hàm SearchRow() dùng để làm gì? Hàm LastRow() dùng để làm gì? Hàm SetCellValue() dùng để làm gì? Hàm GetCellValue() dùng để làm gì? Hàm GetSelectRow() dùng để làm gì?

![Question5](../Practice%202/image_question/Question_5.png)

### Hàm with() dùng để làm gì?

- Hàm with dùng để gọi thuộc tính của đối tượng mà không cần Object.thuộctính

### Hàm DataInsert() dùng để làm gì?

- Thêm 1 hàng vào sheet.

### Hàm SearchRow() dùng để làm gì?

- Kiểm tra tổng số hàng của sheet.

### Hàm LastRow() dùng để làm gì?

- Dùng để lấy hàng cuối cùng của sheet.

### Hàm SetCellValue() dùng để làm gì?

- Dùng để set giá trị của một cột chỉ định trong hàng chỉ định nào đó trong sheet.

### Hàm GetCellValue() dùng để làm gì?

- Dùng để lấy giá trị của một cột chỉ định trong hàng chỉ định nào đó trong sheet.

### Hàm GetSelectRow() dùng để làm gì?

- Dùng để lấy giá trị của một hàng được chọn nào đó trong sheet.

## Question 6: formObj.f_cmd.value = MULTI01 có tác dụng gì? DoSave() dùng để làm gì? DoSave và GetSaveData() dùng trong trường hợp nào?

![Question6](../Practice%202/image_question/Question_6.png)

### formObj.f_cmd.value = MULTI01 có tác dụng gì?

- Có tác dụng để để server biết phải thực hiện FormComand gì.

### DoSave() dùng để làm gì?

- Lưu dữ liệu dựa trên trạng thái giao dịch dữ liệu hoặc cột.

### DoSave và GetSaveData() dùng trong trường hợp nào?

- DoSave() sử dụng trong trường hợp sử lý kết quá trả về.

- GetSaveData() sử dụng trong trường hợp chúng ta không cần xử lý kết quả trả về.

## Question 7: Hàm sheet1_OnDbClick() dùng để làm gì?

![Question7](../Practice%202/image_question/Question_7.png)

- Dùng để khi ta nhấn double vào 1 dòng bất kỳ sẽ hiện ra những giá trị detail của dòng đó.

## Question 8: Hàm ComGetEvent() để làm gì?

![Question8](../Practice%202/image_question/Question_8.png)

- Dùng để lấy gía trị của name trong input.

## Question 9: Hàm ComShowCodeMessage() để làm gì? Hàm ComShowMessage() để làm gì?

![Question9](../Practice%202/image_question/Question_9.png)

- ComShowCodeMessage() : dùng để khi mình truyền 1 cái Code có sẵn trong CoMessage vào thì sẽ hiện ra câu message đó.

- ComShowMessage() : cũng dùng để trả ra câu message nhưng mình lúc truyền vào là 1 chuỗi.

## Question 10: Type, SaveName, Format để làm gì? Hàm SetEditable() để làm gì? Hàm InitColumns() để làm gì? Hàm SetColProperty() để làm gì?

![Question10](../Practice%202/image_question/Question_10.png)

### Type, SaveName, Format để làm gì?

- Type : loại dữ của cột.
- SaveName : Tên tham số được sử dụng để lưu trữ hoặc tìm kiếm dữ liệu.
- Format : Sử dụng để định cấu hình cho cột.

### Hàm SetEditable() để làm gì?

- Dùng để định cấu hình khả năng chỉnh sửa tổng thể.

### Hàm InitColumns() để làm gì?

- Định cấu hình loại dữ liệu, định dạng và chức năng của từng cột.

### Hàm SetColProperty() để làm gì?

- Sử dụng phương pháp này khi bạn muốn xác định động thuộc tính của một cột cụ thể, sau thuộc tính được đặt trong InitColumns.

## Question 11: Hàm ComResizeSheet() để làm gì?

![Question11](../Practice%202/image_question/Question_11.png)

- Đặt thiết kế cơ bản của trang tính.

## Question 12: Dùng phần gạch đỏ, gạch đen khi nào? 2 phần này cùng xuất hiện được không?

![Question12](../Practice%202/image_question/Question_12.png)

- Dùng gạch đỏ khi muốn lấy giá trị của một đối tượng MasterVO
- Dùng gạch đen khi lấy giá trị của các input ngoài sheet nhập vào
- 2 phần này có thể xuất hiện cùng 1 lúc được

## Question 13: Giải thích luồng đi của chức năng Save ( ở Back end)?

- Nhận request từ Client thì vào HtmlAction, xử lý và trả xuống SC, SC trả xuống cho BCImpl thao tác xong trả ngược dần lên FE

## Question 14: Trong thư mục integration có 2 loại file *SQL.java và *SQL.Query. Vậy khi chạy thì system sẽ gọi file nào và file còn lại để làm gì?

- Sẽ gọi file SQL.java
- File còn lại thực hiện các câu Query để trả dữ liệu ra.

## Question 15: Các method begin(), commit(), rollback() có ý nghĩa gì? Dùng khi nào?

![Question15](../Practice%202/image_question/Question_15.png)

- begin() : bắt đầu Transaction.
- commit() dùng để lưu các thay đổi.
- rollback() trở lại trạng thái trước khi thay đổi.
- Dùng khi muốn đảm bảo tính đúng đắn của dữ liệu. Khi có 1 hành động sai thôi thì Transaction sẽ thất bại.

## Question 16: Làm sao file SC trả kết quả về view(jsp) ?

- Khi khai báo Event ở 2 file SC và JSP map với nhau và file mappings nữa.

## Question 17: masterVO[i].getIbflag().equals("I"), masterVO[i].getIbflag().equals("U"), masterVO[i].getIbflag().equals("D") dùng để làm gì?

![Question17](../Practice%202/image_question/Question_17.png)

- Dùng để biết được các event gửi vào muốn làm cái gì.

## Question 18: Giải thích SQLExecuter("").excuteQuery() và SQLExecuter("").excuteBatch()?

![Question18](../Practice%202/image_question/Question_18.png)

- excuteQuery() : sử dụng chủ yếu cho các câu Query select.
  excuteBatch() : sử lý Batch, kết nối Database và thực hiện tất cả các câu SQL trong Batch(sau khi thực hiện xong, bên trong Batch sẽ trống) cứ mỗi lần số lượng câu SQL trong Batch bằng Batch size sẽ thực hiện excuteBatch.

## Question 19: file HTMLAction có dùng để làm gì?

- Dùng để nhận các FormComand trả về từ Client để biết và xử lý các tác vụ.
