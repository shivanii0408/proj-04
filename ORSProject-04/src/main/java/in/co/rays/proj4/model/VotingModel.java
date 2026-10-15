
package in.co.rays.proj4.model;

import java.sql.Connection;
import java.sql.PreparedStatement;

import in.co.rays.proj4.bean.VotingBean;
import in.co.rays.proj4.exception.ApplicationException;
import in.co.rays.proj4.exception.DuplicateRecordException;
import in.co.rays.proj4.util.JDBCDataSource;

public class VotingModel extends BaseModel<VotingBean> {

    @Override
    public long add(VotingBean bean)
            throws ApplicationException, DuplicateRecordException {

        Connection conn = null;

        VotingBean existBean = findByVoterId(bean.getVoterId());

        if (existBean != null) {
            throw new DuplicateRecordException("Voter Id already exists");
        }

        try {
            conn = JDBCDataSource.getConnection();
            conn.setAutoCommit(false);

            String sql = "INSERT INTO st_voter "
                    + "(voter_id, name, age, constituency, hasVoted) "
                    + "VALUES (?, ?, ?, ?, ?)";

            PreparedStatement pstmt = conn.prepareStatement(sql);

            pstmt.setString(1, bean.getVoterId());
            pstmt.setString(2, bean.getName());
            pstmt.setString(3, bean.getAge());
            pstmt.setString(4, bean.getConstituency());
            pstmt.setBoolean(5, bean.isHasVoted());

            pstmt.executeUpdate();
            conn.commit();

        } catch (Exception e) {
            e.printStackTrace();
            JDBCDataSource.trnRollBack(conn);
        } finally {
            JDBCDataSource.closeConnection(conn);
        }

        return 1;
    }

    @Override
    public void update(VotingBean bean)
            throws ApplicationException, DuplicateRecordException {

        Connection conn = null;

        try {
            conn = JDBCDataSource.getConnection();
            conn.setAutoCommit(false);

            String sql = "UPDATE st_voter SET name = ?, age = ?, "
                    + "constituency = ?, hasVoted = ? WHERE voter_id = ?";

            PreparedStatement pstmt = conn.prepareStatement(sql);

            pstmt.setString(1, bean.getName());
            pstmt.setString(2, bean.getAge());
            pstmt.setString(3, bean.getConstituency());
            pstmt.setBoolean(4, bean.isHasVoted());
            pstmt.setString(5, bean.getVoterId());

            pstmt.executeUpdate();
            conn.commit();

        } catch (Exception e) {
            e.printStackTrace();
            JDBCDataSource.trnRollBack(conn);
        } finally {
            JDBCDataSource.closeConnection(conn);
        }
    }

    public VotingBean findByVoterId(String voterId)
            throws ApplicationException {

        VotingBean bean = findByUniqueColumn("voter_id", voterId);
        return bean;
    }

    @Override
    public String getWhereClause(VotingBean bean) {

        StringBuffer sql = new StringBuffer("");

        if (bean != null) {

            if (bean.getVoterId() != null
                    && bean.getVoterId().length() > 0) {
                sql.append(" AND voter_id = '")
                   .append(bean.getVoterId().replace("'", "''"))
                   .append("'");
            }

            if (bean.getName() != null
                    && bean.getName().length() > 0) {
                sql.append(" AND name LIKE '")
                   .append(bean.getName().replace("'", "''"))
                   .append("%'");
            }

            if (bean.getAge() != null
                    && bean.getAge().length() > 0) {
                sql.append(" AND age LIKE '")
                   .append(bean.getAge().replace("'", "''"))
                   .append("%'");
            }

            if (bean.getConstituency() != null
                    && bean.getConstituency().length() > 0) {
                sql.append(" AND constituency LIKE '")
                   .append(bean.getConstituency().replace("'", "''"))
                   .append("%'");
            }
        }

        return sql.toString();
    }

    @Override
    public String getTable() {
        return "st_voter";
    }

    @Override
    public VotingBean getBean() {
        return new VotingBean();
    }
}
