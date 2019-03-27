package net.mem;

import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MemMainTest {

	public static void main(String[] args) {
		// Mybatis-3 기반 JDBC연습
		try {
			//1) DB 환경 설정 관련 파일 가져오기
			String resource="config/jdbc.xml";
			InputStream is=Resources.getResourceAsStream(resource);
			
			//2) DB 연결하기 위한 팩토리빈 생성
			//	→ DBOpen + MemberDAO
			SqlSessionFactory ssf=new SqlSessionFactoryBuilder().build(is);
			System.out.println("DB 연결 성공");
			
			//3) 쿼리문 생성
			//	→ PreparedStatement와 비슷한 기능
			SqlSession sql=ssf.openSession(true);
			
			//4) 쿼리문 실행
			//	→ a) 행추가
			/*int result=sql.insert("mem.insertRow", new MemDTO("튜브5", 19));
			System.out.println("행추가 결과 : "+result);*/

			// 	→ c) 수정
			/*int result=sql.insert("mem.updateRow", new MemDTO(3, "라연", 17));
			System.out.println("행수정 결과 : "+result);*/
			
			// 	→ d) 삭제
			/*int result=sql.insert("mem.deleteRow", new MemDTO(6));
			System.out.println("행삭제 결과 : "+result);*/
			
			// 	→ e) 삭제
			//		→ num=3이하 행 삭제
			/*int result=sql.insert("mem.deleteRow2", 3);
			System.out.println("행삭제 결과 : "+result);*/
			
			//	→ b) 전체 목록
			/*List<MemDTO> list=sql.selectList("mem.selectAll");
			for(int idx=0; idx<list.size(); idx++) {
				MemDTO dto=list.get(idx);
				System.out.print(dto.getNum()+" ");
				System.out.print(dto.getName()+" ");
				System.out.print(dto.getAge()+" ");
				System.out.println();
			}//end
*/			
			//	→ f) 상세보기
			/*MemDTO dto=sql.selectOne("mem.selectRead", new MemDTO(7));
			System.out.print(dto.getNum()+" ");
			System.out.print(dto.getName()+" ");
			System.out.print(dto.getAge()+" ");
			System.out.println();*/
			
			//	→ g) 검색
			//		→ 이름에 '튜' 글자가 있는 행 검색
			List<MemDTO> list=sql.selectList("mem.search", "튜");
			for(int idx=0; idx<list.size(); idx++) {
				MemDTO dto=list.get(idx);
				System.out.print(dto.getNum()+" ");
				System.out.print(dto.getName()+" ");
				System.out.print(dto.getAge()+" ");
				System.out.println();
			}//end
			
			
		}catch(Exception e) {
			System.out.println("실패 : "+e);
		}//try end
	}//main() end

}//class end
