select top 5 * 
from cursoprogramado
order by 1 desc;

select * from curso;

select * from tarifa;

select t.PrecioVenta tarifa
from curso c
join tarifa t on c.IdTarifa = t.IdTarifa
where c.IdCurso = 'C004';
go

sp_help cursoprogramado;
go

select * from parametro;



select count(1) cont 
from curso 
where IdCurso = 'C002';



select count(1) cont 
from ciclo 
where IdCiclo = '2016-07' 
and (FecInicio > getdate())
or (year(FecInicio) = year(getdate())
and month(FecInicio) = month(getdate()));

insert into CursoProgramado(IdCurso,
IdCiclo,Vacantes,Matriculados,
PreCursoProg,Horario,Activo) 
values(?,?,?,0,?,?,1)
