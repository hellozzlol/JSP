package co.micol.prj.emp;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import co.micol.prj.comm.DAO;

public class EmpDAO extends DAO {

	// JOBs 전체 조회
	public ArrayList<jobsVO> selectJobs() {

		ArrayList<jobsVO> list = new ArrayList<>();

		try {
			getConnect();
			String sql = "select * from jobs order by job_id";
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			while (rs.next()) {
				jobsVO vo = new jobsVO();
				vo.setJobId(rs.getString("job_id"));
				vo.setJobTitle(rs.getString("job_title"));
				list.add(vo);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			// 4.연결해제(보통 파일러리에 내비둠)
			disconnect();
		}
		return list;

	}

	// 전체조회
	public ArrayList<EmpVO> selectAll(String departmentId) {
		ArrayList<EmpVO> list = new ArrayList<EmpVO>();

		try {
			// 1.연결
			getConnect();
			// 2.sql구문준비
			String sql = " select * from employees";
			if (departmentId != null && !departmentId.isEmpty()) {
				sql += " where department_id = ? ";
			}
			sql += " order by employee_id";
			psmt = conn.prepareStatement(sql);
			if (departmentId != null && !departmentId.isEmpty()) {
				psmt.setString(1, departmentId);
			}
			// 실행
			ResultSet rs = psmt.executeQuery();
			// 조회결과 list에 담기
			while (rs.next()) {
				EmpVO vo = new EmpVO();
				vo.setEmployeeId(rs.getString("employee_id"));
				vo.setLastname(rs.getString("last_name"));
				vo.setEmail(rs.getString("email"));
				vo.setHiredate(rs.getString("hire_date"));
				vo.setDepartmentId(rs.getString("department_id"));
				list.add(vo);

			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 4.연결해제(보통 파일러리에 내비둠)
			disconnect();
		}
		return list;

	}

	// 단건조회
	public EmpVO selectOne(String employeeId) {
		EmpVO vo = new EmpVO();
		try {
			//연결
			getConnect();
			String spl = "select * from employees where employee_id = ?";
			psmt = conn.prepareStatement(spl);
			psmt.setString(1, employeeId);
			rs=psmt.executeQuery();
			if(rs.next()) {
				vo.setEmployeeId(rs.getString("employee_id"));
				vo.setLastname(rs.getString("last_name"));
				vo.setEmail(rs.getString("email"));
				vo.setHiredate(rs.getString("hire_date"));
				vo.setJobId(rs.getString("job_id"));
				vo.setDepartmentId(rs.getString("department_id"));
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			//연결해제
			disconnect();
		}
		return vo;

	}

	// 등록

	public int empinsert(EmpVO vo) {
		int cnt = 0;
		try {
			//1.connect
			getConnect();
			String sql = " insert into  employees( employee_id, last_name, email, job_id, hire_date, department_id)"
					+ " values((select max(employee_id)+1 from employees),"
			+"?,?,?,?,?)";
			
//2.splㄱㄱ구문준비
			psmt = conn.prepareStatement(sql);
			//3.spl구문실핼
			//psmt.setString(1, vo.getEmployeeId());
			psmt.setString(1, vo.getLastname());
			psmt.setString(2, vo.getEmail());
			psmt.setString(3, vo.getJobId());
			psmt.setString(4, vo.getHiredate());
			psmt.setString(5, vo.getDepartmentId());

			cnt = psmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		// 완성
		return cnt;
	}

	// 수정

	public int update(EmpVO vo) {
		int cnt = 0;
		try {
			
		}catch(Exception e) {
			
		}finally {
			
		}
		return cnt;
	}
	
	
	
	// 삭제

	public int delete(EmpVO vo) {
		int cnt=0;
		try {
			//1.연결
			getConnect();
			String sql = " delete from employees where employee_id =?";
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getEmployeeId());	
			cnt = psmt.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			//2.연결해제
			disconnect();
		}
		return cnt;
	}
	
	
	
	
	
	
	
}
